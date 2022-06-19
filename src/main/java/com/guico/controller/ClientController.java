package com.guico.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guico.pojo.*;
import com.guico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private PetMapperImpl petMapper;
    @Autowired
    private PetOwnerMapperImpl petOwnerMapper;
    @Autowired
    private PetVisitMapperImpl petVisitMapper;
    @Autowired
    private SpecMapperImpl specMapper;
    @Autowired
    private VetMapperImpl vetMapper;
    @Autowired
    private TypeMapperImpl typeMapper;


    @RequestMapping("/test")
    public void test(int id) {
        System.out.println(vetMapper.selectById(id));
    }


    //    兽医业务代码区域
//    跳转到vet页面
    @RequestMapping("/vet")
    public String vet(HttpServletRequest request, HttpServletResponse resp) {
        List<Spec> specs = specMapper.selectAll();
        request.setAttribute("specs", specs);
        System.out.println(specs);
        return "vet";
    }

    //
    @RequestMapping("/selectVets")
    public String selectVets(HttpServletRequest req) {
        String name = req.getParameter("vetName");
        String spec = req.getParameter("vetSpec");
        System.out.println(name + " " + spec);
        List<Vet> res;
        if (name.equals("") && spec != null) {
            res = vetMapper.selectVetBySpecId(Integer.parseInt(spec));
            System.out.println("select by spec");
        } else if (!name.equals("") && spec == null) {
            res = vetMapper.selectByName(name);
            System.out.println("select by name");
        } else if (!name.equals("") && spec != null) {
            res = vetMapper.selectVetBySpecAndName(Integer.parseInt(spec), name);
            System.out.println("select by spec and name");
        } else {
            res = vetMapper.selectAll();
        }
        req.setAttribute("res", res);
        System.out.println(res);
        return "vetRes";
    }


    //    宠物业务区域
//    跳转到petOwner页面
    @RequestMapping("/pet")
    public String petOwner(HttpServletRequest req, HttpServletResponse resp) {
        return "pet";
    }

    //    从请求中获取petName,根据其获取宠物信息的json字符串
    @RequestMapping(value = "/selectByPetName", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String petInfo(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, UnsupportedEncodingException {
        System.out.println("select pet by petName");
        String petName = req.getParameter("petName");
        System.out.println(petName);
        List<Pet> pets = petMapper.selectByName(petName);
        System.out.println(pets);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pets);
        System.out.println(json);
        return json;
    }

    //    从请求中获取petOwnerName,根据其获取宠物信息的List集合并以json字符串形式返回
    @RequestMapping(value = "/selectByOwnerName", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectByOwnerName(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, JsonProcessingException {
        System.out.println("select pet by ownerName");
        String petOwnerName = req.getParameter("ownerName");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(petOwnerName);
        List<Pet> petOwners = petMapper.selectByOwnerName(petOwnerName);
        return objectMapper.writeValueAsString(petOwners);
    }


    //    从请求中获取ownerId,根据id调用mapper获取宠物主人信息，并将宠物主人信息展示在petOwnerInfo页面
    @RequestMapping("/ownerInfo")
    public String petOwnerInfoPage(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("ownerInfo");
        int ownerId = Integer.parseInt(req.getParameter("ownerId"));
        PetOwner petOwner = petOwnerMapper.selectPetOwnerByPetOwnerId(ownerId);
        System.out.println(petOwner);
        req.getSession().setAttribute("owner", petOwner);
        return "ownerInfo";
    }

    //    根据提交表单信息构建一个PetOwner对象，并调用mapper修改数据库中的宠物主人信息
    @RequestMapping("/updatePetOwner")
    public void updatePetOwner(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("update pet owner");
        int id = Integer.parseInt(req.getParameter("ownerId"));
        String name = req.getParameter("ownerName");
        String address = req.getParameter("ownerAddress");
        String city = req.getParameter("ownerCity");
        String phone = req.getParameter("ownerPhone");
        PetOwner owner = new PetOwner(id, name, address, city, phone);
        System.out.println(owner);
        petOwnerMapper.updatePetOwner(owner);
//        更新session中的owner
        owner = petOwnerMapper.selectPetOwnerByPetOwnerId(owner.getPetOwnerId());
        System.out.println(owner);
        req.getSession().setAttribute("owner", owner);
        try {
//            弹窗提示修改成功并跳转到ownerInfo页面
            res.getWriter().write("<script>alert('update success');window.location.href='/ownerInfo?ownerId="+owner.getPetOwnerId()+"';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/insertPetOwner")
    public void insertPetOwner(HttpServletRequest req,HttpServletResponse res){
        System.out.println("insert pet owner");
        String name = req.getParameter("ownerName2");
        String address = req.getParameter("ownerAddress2");
        String city = req.getParameter("ownerCity2");
        String phone = req.getParameter("ownerPhone2");
        PetOwner owner = new PetOwner(name,address,city,phone);
        petOwnerMapper.insertPetOwner(owner);
        PetOwner owner2 = (PetOwner)req.getSession().getAttribute("owner");
        try {
//              弹窗提示后刷新页面
            res.getWriter().write("<script>alert('insert success');window.location.href='/ownerInfo?ownerId="+owner2.getPetOwnerId()+"';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    宠物业务区域
//    从请求中获取petId,根据id调用mapper获取宠物信息，并将宠物信息展示在petInfo页面
    @RequestMapping("/petInfo")
    public String petInfoPage(HttpServletRequest req,HttpServletResponse resp){
        int petId = Integer.parseInt(req.getParameter("petId"));
        req.setAttribute("petId",petId);
        Pet pet = petMapper.selectById(petId);
        List<Type> types = typeMapper.selectAll();
        List<PetOwner> owners = petOwnerMapper.selectAllPetOwners();
        req.getSession().setAttribute("pet",pet);
        req.getSession().setAttribute("types",types);
        req.getSession().setAttribute("owners",owners);
        return "petInfo";
    }

    @RequestMapping("/updatePet")
    public void updatePet(HttpServletResponse res, HttpServletRequest req){
        System.out.println("update pet");
        int petId = Integer.parseInt(req.getParameter("petId"));
        System.out.println(petId);
        String petName = req.getParameter("petName");
        String petBirthDate = req.getParameter("petBirthDate");
        int petTypeId = Integer.parseInt(req.getParameter("petType"));
        System.out.println(req.getParameter("petOwnerName"));
        int petOwnerId = Integer.parseInt(req.getParameter("petOwnerName"));
        Type type = typeMapper.selectById(petTypeId);
        PetOwner owner = petOwnerMapper.selectPetOwnerByPetOwnerId(petOwnerId);
        Pet pet= new Pet(petId,petName,petBirthDate,type,owner);
        req.getSession().setAttribute("pet",pet);
        petMapper.updatePet(pet);
        try {
            res.getWriter().write("<script>alert('update success');window.location.href='/petInfo?petId="+petId+"';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/insertPet")
    public void insertPet(HttpServletResponse res, HttpServletRequest req){
        System.out.println("insert pet");
        Pet pet = (Pet) req.getSession().getAttribute("pet");
        int petId = pet.getId();
        String petName = req.getParameter("petName");
        String petBirthDate = req.getParameter("petBirthDate");
        int petTypeId = Integer.parseInt(req.getParameter("petType"));
        int petOwnerId = Integer.parseInt(req.getParameter("petOwnerName"));
        Type type = typeMapper.selectById(petTypeId);
        PetOwner owner = petOwnerMapper.selectPetOwnerByPetOwnerId(petOwnerId);
        pet= new Pet(petName,petBirthDate,type,owner);
        petMapper.insertPet(pet);
        try {
            res.getWriter().write("<script>alert('insert success');window.location.href='/petInfo?petId="+petId+"';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    浏览历史区域
//    跳转到visit页面
    @RequestMapping("/visit")
    public String visit(HttpServletRequest req,HttpServletResponse resp){
        Pet pet =(Pet) req.getSession().getAttribute("pet");
        List<PetOwner> owners = petOwnerMapper.selectAllPetOwners();
        List<PetVisit> visits = petVisitMapper.selectByPetId(pet.getId());
        HttpSession session = req.getSession();
        session.setAttribute("visits",visits);
        session.setAttribute("owners",owners);
        return "visit";
    }

    @RequestMapping("/insertVisit")
    public void insertVisit( HttpServletRequest req, HttpServletResponse res){
        int petId = Integer.parseInt(req.getParameter("petId"));
        String visitDate = req.getParameter("petVisitDate");
        String visitDesc = req.getParameter("petVisitDesc");
        PetVisit visit = new PetVisit(visitDate,visitDesc,petId);
        petVisitMapper.insertVisit(visit);
        try {
            res.getWriter().println("<script>alert('add success');window.location.href='/visit';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// type区域
    @RequestMapping("/type")
    public String type(HttpServletRequest req, HttpServletResponse resp){
        return "type";
    }

    @RequestMapping("/insertType")
    public void insertType(HttpServletRequest req, HttpServletResponse res){
        String typeName = req.getParameter("typeName");
        Type type = new Type(typeName);
        typeMapper.insertType(type);
        try {
            res.getWriter().println("<script>alert('add success');window.location.href='/type';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

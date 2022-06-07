package com.guico.controller;

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

    private void checkUser(HttpServletRequest  req,HttpServletResponse res){
        if(req.getSession().getAttribute("emp")==null) {
            try {
                res.getWriter().println("<script>alert('请先登录！');window.location.href='/login'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/test")
    public void test(int id){
        System.out.println(vetMapper.selectById(id));
    }


//    兽医业务代码区域
//    跳转到vet页面
    @RequestMapping("/vet")
    public String  vet(HttpServletRequest request,HttpServletResponse resp){
        checkUser(request,resp);
        List<Vet> vets = vetMapper.selectAll();
        request.setAttribute("vets",vets);
        for(Vet vet:vets)
            System.out.println(vet);
        return "vet";
    }
//    从请求中获取vetName,根据其获取兽医信息
//    感觉这个功能在前端可以用ajax实现
    @RequestMapping("/getSpecByVetName")
    @ResponseBody
    public String vetInfo(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        checkUser(req,resp);
        String vetName = req.getParameter("vetName");
        URLEncoder.encode(vetName,"utf-8");
        System.out.println(vetName);
        Vet vet = vetMapper.selectByName(vetName);
        System.out.println(vet);
        String specName = vet.getSpecName();
        System.out.println(specName);
        specName = URLEncoder.encode(specName,"utf-8");
        System.out.println(specName);
        return specName;
    }



//    宠物业务区域
//    跳转到petOwner页面
    @RequestMapping("/pet")
    public String petOwner(HttpServletRequest req, HttpServletResponse resp){
        checkUser(req,resp);
        return "pet";
    }
//    从请求中获取petName,根据其获取宠物信息的json字符串
    @RequestMapping(value = "/selectByPetName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String petInfo(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, UnsupportedEncodingException {
        checkUser(req,resp);
        String petName = req.getParameter("petName");
        List<Pet> pets = petMapper.selectByName(petName);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pets);
        System.out.println(json);
        return json;
    }

//    从请求中获取petOwnerName,根据其获取宠物信息的List集合并以json字符串形式返回
    @RequestMapping(value = "/selectByOwnerName" ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String  selectByOwnerName(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException, JsonProcessingException {
        checkUser(req,resp);
        String petOwnerName = req.getParameter("ownerName");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(petOwnerName);
        List<Pet> petOwners = petMapper.selectByOwnerName(petOwnerName);
        return objectMapper.writeValueAsString(petOwners);
    }


//    从请求中获取ownerId,根据id调用mapper获取宠物主人信息，并将宠物主人信息展示在petOwnerInfo页面
    @RequestMapping("/ownerInfo")
    public String petOwnerInfoPage(HttpServletRequest req,HttpServletResponse resp){
        checkUser(req, resp);
        int ownerId = Integer.parseInt(req.getParameter("ownerId"));
        PetOwner petOwner = petOwnerMapper.selectPetOwnerByPetOwnerId(ownerId);
        System.out.println(petOwner);
        req.getSession().setAttribute("owner",petOwner);
        return "ownerInfo";
    }

//    根据提交表单信息构建一个PetOwner对象，并调用mapper修改数据库中的宠物主人信息
    @RequestMapping("/updatePetOwner")
    public void updatePetOwner(HttpServletRequest req,HttpServletResponse res){
        int id = Integer.parseInt(req.getParameter("ownerId"));
        String name = req.getParameter("ownerName");
        String address = req.getParameter("ownerAddress");
        String city = req.getParameter("ownerCity");
        String phone = req.getParameter("ownerPhone");
        PetOwner owner = new PetOwner(id,name,address,city,phone);
        System.out.println(owner);
        petOwnerMapper.updatePetOwner(owner);
//        更新session中的owner
        owner = petOwnerMapper.selectPetOwnerByPetOwnerId(owner.getPetOwnerId());
        System.out.println(owner);
        req.getSession().setAttribute("owner",owner);
        try {
//            弹窗提示修改成功并跳转到ownerInfo页面
            res.getWriter().write("<script>alert('update success');window.location.href='/ownerInfo?ownerId="+id+"';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/insertPetOwner")
    public void insertPetOwner(HttpServletRequest req,HttpServletResponse res){
        String name = req.getParameter("ownerName2");
        String address = req.getParameter("ownerAddress2");
        String city = req.getParameter("ownerCity2");
        String phone = req.getParameter("ownerPhone2");
        PetOwner owner = new PetOwner(name,address,city,phone);
        petOwnerMapper.insertPetOwner(owner);
        try {
            res.getWriter().println("<script>alert('add success');;window.location.href='/pet'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    宠物业务区域
//    从请求中获取petId,根据id调用mapper获取宠物信息，并将宠物信息展示在petInfo页面
    @RequestMapping("/petInfo")
    public String petInfoPage(HttpServletRequest req,HttpServletResponse resp){
        checkUser(req, resp);
        int petId = Integer.parseInt(req.getParameter("petId"));
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
        int petId = Integer.parseInt(req.getParameter("petId"));
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
        String petName = req.getParameter("petName");
        String petBirthDate = req.getParameter("petBirthDate");
        int petTypeId = Integer.parseInt(req.getParameter("petType"));
        int petOwnerId = Integer.parseInt(req.getParameter("petOwnerName"));
        Type type = typeMapper.selectById(petTypeId);
        PetOwner owner = petOwnerMapper.selectPetOwnerByPetOwnerId(petOwnerId);
        Pet pet= new Pet(petName,petBirthDate,type,owner);
        petMapper.insertPet(pet);
        try {
            res.getWriter().write("<script>alert('add success');window.location.href='/pet';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    浏览历史区域
//    跳转到visit页面
    @RequestMapping("/visit")
    public String visit(HttpServletRequest req,HttpServletResponse resp){
        checkUser(req, resp);
        Pet pet =(Pet) req.getSession().getAttribute("pet");
        List<PetOwner> owners = petOwnerMapper.selectAllPetOwners();
        List<PetVisit> visits = petVisitMapper.selectAll();
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
        checkUser(req, resp);
        return "type";
    }

    @RequestMapping("/insertType")
    public void insertType(HttpServletRequest req, HttpServletResponse res){
        checkUser(req, res);
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

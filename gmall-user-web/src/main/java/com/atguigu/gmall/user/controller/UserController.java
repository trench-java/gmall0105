package com.atguigu.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = userService.getAllUser();

        return umsMembers;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

    /**
     * 增加收货地址
     */
    @ResponseBody
    @RequestMapping("addReceiveAddress")
    public String addReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){
        int i = userService.addReceiveAddress(umsMemberReceiveAddress);
        if(i > 0){
            return "ok";
        }
        return "error";
    }

    /**
     * 修改收货地址
     */
    @ResponseBody
    @RequestMapping("updateReceiveAddress")
    public String updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){
        int i = userService.updateReceiveAddress(umsMemberReceiveAddress);
        if(i > 0){
            return "ok";
        }
        return "error";
    }

    /**
     * 删除收货地址
     */
    @ResponseBody
    @RequestMapping("deleteReceiveAddress")
    public String deleteReceiveAddress(String id){
        int i = userService.deleteReceiveAddressById(id);
        if(i > 0){
            return "ok";
        }
        return "error";
    }

    /**
     * 增加人员
     */
    @ResponseBody
    @RequestMapping("addUmsMember")
    public String addUmsMember(UmsMember umsMember){
        int i = userService.addUmsMember(umsMember);
        if(i > 0){
            return "ok";
        }
        return "error";
    }

    /**
     * 修改人员
     */
    @ResponseBody
    @RequestMapping("updateMember")
    public String updateMember(UmsMember umsMember){
        int i = userService.updateMember(umsMember);
        if(i > 0){
            return "ok";
        }
        return "error";
    }

    /**
     * 删除人员
     */
    @ResponseBody
    @RequestMapping("deleteMember")
    public String deleteMember(String id){
        int i = userService.deleteMember(id);
        if(i > 0){
            return "ok";
        }
        return "error";
    }


    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

}

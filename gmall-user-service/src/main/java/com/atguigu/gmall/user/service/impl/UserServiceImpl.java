package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
//        List<UmsMember> list = userMapper.selectAllUser();
        List<UmsMember> umsMembers = userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }

    @Override
    public int addReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int count = umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);
        return count;
    }

    @Override
    public int updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int count = umsMemberReceiveAddressMapper.updateByPrimaryKey(umsMemberReceiveAddress);
        return count;
    }

    @Override
    public int deleteReceiveAddressById(String id) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setId(id);
        int count = umsMemberReceiveAddressMapper.deleteByPrimaryKey(umsMemberReceiveAddress);
        return count;
    }

    @Override
    public int addUmsMember(UmsMember umsMember) {
        int count = userMapper.insert(umsMember);
        return count;
    }

    @Override
    public int updateMember(UmsMember umsMember) {
        Example e = new Example(UmsMember.class);
        e.createCriteria().andEqualTo("id",umsMember.getId());
        int count = userMapper.updateByExample(umsMember, e);
        return count;
    }

    @Override
    public int deleteMember(String id) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        int count = userMapper.deleteByPrimaryKey(umsMember);
        return count;
    }
}

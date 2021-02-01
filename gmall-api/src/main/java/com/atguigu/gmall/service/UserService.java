package com.atguigu.gmall.service;



import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    int addReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    int updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    int deleteReceiveAddressById(String id);

    int addUmsMember(UmsMember umsMember);

    int updateMember(UmsMember umsMember);

    int deleteMember(String id);

}

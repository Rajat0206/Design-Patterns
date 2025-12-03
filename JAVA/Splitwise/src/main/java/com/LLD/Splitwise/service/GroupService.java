package com.LLD.Splitwise.service;

import com.LLD.Splitwise.entity.Group;

public interface GroupService {
    public void addMemberToGroup(Long groupId, Long userId);
    public void removeMemberFromGroup(Long groupId, Long userId);
    public Group getGroup(Long groupId);
}

package com.LLD.Splitwise.service.impl;

import com.LLD.Splitwise.entity.Group;
import com.LLD.Splitwise.entity.User;
import com.LLD.Splitwise.repository.GroupRepository;
import com.LLD.Splitwise.repository.UserRepository;
import com.LLD.Splitwise.service.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    GroupRepository groupRepository;
    UserRepository userRepository;

    GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addMemberToGroup(Long groupId, Long userId) {
        Group group = this.groupRepository.getReferenceById(groupId);
        User user = this.userRepository.getReferenceById(userId);

        group.getUsers().add(user);
        this.groupRepository.save(group);
    }

    @Override
    public void removeMemberFromGroup(Long groupId, Long userId) {
        Group group = this.groupRepository.getReferenceById(groupId);
        User user = this.userRepository.getReferenceById(userId);

        group.getUsers().remove(user);
        this.groupRepository.save(group);
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.getReferenceById(groupId);
    }
}

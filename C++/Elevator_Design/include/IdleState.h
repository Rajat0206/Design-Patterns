#pragma once
#include <iostream>
#include "../include/ElevatorStateAbs.h"
#include "Elevator.h"
#include <vector>
class IdleState:public ElevatorStateAbs{
    Elevator* elevator;
    public:
    virtual void move_up(std::vector<int> floors) override{}
    virtual void move_down(std::vector<int> floors) override{}
    //virtual void open_door() override{}
    //virtual void close_door() override{}
    virtual ElevatorStates get_state() override;
};
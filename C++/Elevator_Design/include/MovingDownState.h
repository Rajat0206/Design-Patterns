#include "../include/ElevatorStateAbs.h"

class MovingDownState:public ElevatorStateAbs{
    public:
    virtual void move_down() override{}
    virtual void close_door() override{}
    virtual void check_capacity(){}
    virtual ElevatorStates get_state()=0;
};
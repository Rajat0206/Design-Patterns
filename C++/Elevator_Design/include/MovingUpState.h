#include "../include/ElevatorStateAbs.h"

class MovingUpState:public ElevatorStateAbs{
    public:
    virtual void move_up() override{}
    virtual void close_door() override{}
    virtual void check_capacity(){}
    virtual ElevatorStates get_state()=0;
};
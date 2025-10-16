#include "MovingUpState.h"
#include <iostream>

void MovingUpState::move_up(){
    std::cout << "Already moving up. Continuing upward direction";
}
void MovingUpState::close_door(){}
void MovingUpState::check_capacity(){}
ElevatorStates MovingUpState::get_state(){}
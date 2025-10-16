#include "MovingDownState.h"
#include <iostream>

void MovingDownState::move_down(){
    std::cout << "Already moving down. Continuing downward direction";
}
void MovingDownState::close_door(){}
void MovingDownState::check_capacity(){}
ElevatorStates MovingDownState::get_state(){}
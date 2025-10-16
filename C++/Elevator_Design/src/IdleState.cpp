#include "IdleState.h"
#include <iostream>
#include <vector>
#include <ElevatorStates.h>
#include "Elevator.h"

void IdleState::move_up(std::vector<int> floors){
    if(!elevator->validate_capacity() && elevator->get_current_floor()==elevator->get_max_floor()){
        throw std::logic_error("Cannot MoveUp");
    }
    for(auto f:floors){
        if(f>elevator->get_current_floor()){
            elevator->insert_floor(f,true);
        }
        else if(f < elevator->get_current_floor()){
            elevator->insert_floor(f,false);
        }
        else{
            std::cout<<"You are on same floor";
        }
    }
    std::cout<<"Elevator Moving up";
}
void IdleState::move_down(std::vector<int> floors){

}
//void IdleState::open_door(){}
//void IdleState::close_door(){}
ElevatorStates IdleState::get_state(){
    return ElevatorStates::Idle;
}
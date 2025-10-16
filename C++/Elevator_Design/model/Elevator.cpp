#include "../include/Elevator.h"

#include <iostream>
#include "ElevatorStateAbs.h"
#include "../include/IdleState.h"
#include "ElevatorStates.h"

Elevator::Elevator(int max_capacity=8,int max_floors):max_capacity(max_capacity),max_floors(max_floors){
    this->elevatorstatemac=new IdleState();
}
    
void Elevator::move_up(std::vector<int> floors){
    
}
void Elevator::move_down(std::vector<int> floors){}
void Elevator::open_door(){}
void Elevator::close_door(){}
bool Elevator::validate_capacity(){
    return capacity<=max_capacity;
}
void Elevator::set_state(){}
void insert_floor(int floor,bool is_up_floor){
    if(is_up_floor){
        up_floors.insert(floor);
    }
    else{
        down_floors.insert(floor);
    }
}
void remove_floor(bool is_up_floor){
    if(is_up_floor){
        up_floors.erase(up_floors.begin());
    }
    else{
        down_floors.erase(down_floors.begin());
    }
}
int Elevator::get_current_floor(){
    return current_floor;
}
void Elevator::set_capacity(int number_of_people){
    capacity+=number_of_people;
}
int Elevator::get_max_floor(){
    return max_floors;
}
bool Elevator::is_door_open(){}
void Elevator::set_door_open(){}    

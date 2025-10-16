#pragma once
#include <iostream>
#include <set>
#include <vector>
#include "ElevatorStateAbs.h"
#include "ElevatorStates.h"

class Elevator{
    ElevatorStateAbs* elevatorstatemac;
    int capacity;
    bool door_open;
    int current_floor;
    int max_floors;
    std::set<int> up_floors;
    std::set<int,std::greater<int>> down_floors;
    const int max_capacity;
    //const int max_weight_Kg=650;
    public:
    Elevator(int max_capacity,int max_floors);

    void insert_floor(int floor,bool is_up_floor){}
    void remove_floor(bool is_up_floor){}
    void move_up(std::vector<int> floors);
    void move_down(std::vector<int> floors);
    void open_door();
    void close_door();
    bool validate_capacity();
    void set_state();
    int get_current_floor();
    int get_max_floor();
    void set_capacity(int number_of_people);
    bool is_door_open();
    void set_door_open();
};
#include "ElevatorStates.h"
#include <stdexcept>

class ElevatorStateAbs{
    public:
    virtual void move_up(std::vector<int> floors){
        throw std::logic_error("Cannot MoveUp");
    }
    virtual void move_down(std::vector<int> floors){
        throw std::logic_error("Cannot MoveDown");
    }
    virtual void open_door(){
        throw std::logic_error("Cannot Open_door");
    }
    virtual void close_door(){
        throw std::logic_error("Cannot Close_door");
    }
    
    virtual int get_in_elevator(int number_of_people){}
    virtual int get_out_elevator(int number_of_people){}

    virtual ElevatorStates get_state()=0;
};


#include <bits/stdc++.h>
using namespace std;
#include <string>
#include "../states/ATMStateMachine.h"


class ATM{
    const string atmId;   // equivalent to 'private final String atmId'
    ATMStateMachine atmStateMachine; //Never instantiate abstract classes directly.Use pointers/references to abstract classes.

    //Always implement a concrete subclass that provides the logic for all pure virtual methods.
};
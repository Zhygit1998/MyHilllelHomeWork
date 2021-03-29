package lesson_4;

public class Car {
    float vTank;
    float balanceFuel;
    float fuelConsumption;
    Car(float v, float b, float c){
        vTank=v;
        balanceFuel=b;
        fuelConsumption=c;
    }

    float refueling(){
        return balanceFuel= balanceFuel+(vTank-balanceFuel);
    }
    float fuelBalance(float distance){
        return balanceFuel - (distance*fuelConsumption/100);
    }
    float refuelingInRoad(float distance){
        return vTank - (balanceFuel - distance*fuelConsumption/100);
    }

}

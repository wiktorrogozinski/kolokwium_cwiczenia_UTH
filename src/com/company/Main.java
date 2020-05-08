package com.company;


import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ThreadLocalRandom;

class Room {
    final int size;
    private String color;
    private static int noOfRooms;

    public Room(int size, String color) {
        this.size = size;
        this.color = color;
        ++noOfRooms;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Room{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }



}

class Kitchen extends Room{
    private  ovenType type;

    public Kitchen(int size, String color, ovenType type) {
        super(size, color);
        this.type = type;
    }

    public ovenType getType() {
        return type;
    }

    public void setType(ovenType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "size=" + size +
                ", ovenType=" + type + " color" +getColor()+
                '}';
    }

}

class Bathroom extends Room{
    private  bathTubeOrShower type;

    public Bathroom(int size, String color, bathTubeOrShower type) {
        super(size, color);
        this.type = type;
    }

    public bathTubeOrShower getType() {
        return type;
    }

    public void setType(bathTubeOrShower type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Bathroom{" +
                "size=" + size +
                ", type=" + type + " color=" +getColor()+
                '}';
    }
}
class executing {
    Room[] building = new Room[10];
    int numberOfKitchens = 0;
    int numberOfOrdinaryRooms = 0;
    int numberOfBathroom = 0;

    public Room[] generateRooms() {
        for (int i = 0; i < building.length; ++i) {
            int range = ThreadLocalRandom.current().nextInt(0, 101);
            int size = ThreadLocalRandom.current().nextInt(3, 13);
            if (range < 10) {
                building[i] = new Kitchen(size, "black", ovenType.ELECTRONIC);
                ++numberOfKitchens;
            } else if (range > 75) {
                building[i] = new Room(size, "yellow");
                ++numberOfOrdinaryRooms;
            } else {
                building[i] = new Bathroom(size, "brown", bathTubeOrShower.SHOWER);
                ++numberOfBathroom;
            }
        }
        return this.building;
    }



    public void printRooms() {
        for (Room space: building ) {
            System.out.println(space.toString());
        }
    }

    public void printNumbers() {
        System.out.println("Łazienki: "+numberOfBathroom);
        System.out.println("Pokoje: "+numberOfOrdinaryRooms);
        System.out.println("Kuchnie: "+numberOfKitchens);
    }

    public void paintAll() {
        for (Room paint: building) {
            paint.setColor("white");

        }
    }
}


enum bathTubeOrShower {BATHTUB,SHOWER}
enum ovenType {ELECTRONIC,GAS};

public class Main {
    public static void main(String[] args) {
        executing object = new executing();
        object.generateRooms();
        object.printRooms();
        object.printNumbers();
        object.paintAll();
        object.printRooms();



    }

}

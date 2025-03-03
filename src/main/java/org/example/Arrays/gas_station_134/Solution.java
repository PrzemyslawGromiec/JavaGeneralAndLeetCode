package org.example.Arrays.gas_station_134;

public class Solution {
    /*
    * find a starting gas station from which you can complete full
    * circular route ensuring the car never runs out of gas
    * n - gas stations arranged in a circle
    * you can start at any station with empty tank
    * gas[i] - you receive at each i station
    * cost[i] - you spend to drive to the next station (i+1)
    * goal is to find a starting station that lets you complete one full loop
    * without running out of gas
    *
    * */
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0, totalCost = 0;  // Track total gas and cost
        int tank = 0;  // Simulates the fuel balance at each step
        int gasStationIndex = 0;  // Stores the potential starting station

        System.out.println("🚀 Step 1: Calculate total gas and cost");
        for (int i = 0; i < gas.length; i++) {
            totalGain += gas[i];
            totalCost += cost[i];
        }
        System.out.println("Total Gas Available: " + totalGain);
        System.out.println("Total Gas Needed: " + totalCost);

        // Step 2: If total gas is less than total cost, return -1
        if (totalGain < totalCost) {
            System.out.println("❌ Impossible to complete the circuit! Returning -1");
            return -1;
        }

        System.out.println("\n🚀 Step 2: Simulate the journey station by station");
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];  // Update current fuel balance
            System.out.println("⛽ At Station " + i + " | Gas: " + gas[i] + ", Cost: " + cost[i]
                    + " | Net Gain: " + (gas[i] - cost[i]) + " | Tank: " + tank);

            // If tank is empty, reset and restart from the next station
            if (tank < 0) {
                System.out.println("🔄 Restarting at station " + (i + 1) + " since tank is empty!");
                gasStationIndex = i + 1;
                tank = 0;  // Reset fuel balance
            }
        }

        System.out.println("\n✅ Returning gas station index: " + gasStationIndex);
        return gasStationIndex;
    }


}

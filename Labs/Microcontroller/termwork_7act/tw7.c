#include<LPC21xx.h>
unsigned int delay;
int main() {
  PINSEL1 = 0x00000000; // Configure P0.16 to P0.23 as GPIO
  IO0DIR = 0xFFFFFFFF;  // Configure P0.16 to P0.23 as OUTPUT
  while(1) {
    IO0SET = 0x00FF0000; // Set pins 16-23 of Port 0 
    for (delay=0; delay<1000000; delay++);
    IO0CLR = 0x00FF0000; // Clear pins 16-23 of Port 0
    for (delay=0; delay<1000000; delay++);
  }
}

// Develop an ARM7 embedded C program to blink the LEDs 
// connected to pins 16 to 23 of ARM7 port P0.

#include<LPC21xx.h>
unsigned int delay;

int main() {
	PINSEL1 = 0x00000000;		// configure P0.16 to P0.23 as GPIO
	IO0DIR = 0xFFFFFFFF;		// configure P0.16 to P0.23 as OUTPUT
	while(1) {
		IO0SET = 0x00FF0000;	// set pins 16-23 of Port 0
		for (delay=0; delay<10000; delay++);
		IO0CLR = 0x00FF0000;	// clear pins 16-23 of Port 0
		for (delay=0; delay<10000; delay++);
	}
}

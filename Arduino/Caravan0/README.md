The program I wrote to control the caravan.
The GUI part is handled by RemoteXY. It basically gets the user input and show various values.
The program utilizes EEPROM reading-writing, RTE (Real-Time Clock) Module and analog reading.
I used RTE to get and check time, stored time data on EEPROM so it can switch on and off certain mechanism in desired time interval.
To work with relay module , HIGH and LOW voltages are reversed.

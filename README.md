# Babysitter Kata #

## Instructions ##
- Clone repo (e.g. from Git Bash: ```git clone https://github.com/sdolman/babysitter-kata```)
- Test report may be generated with ```./gradlew test``` at .\build\reports\tests\test\index.html

## About the Kata ##
Source: https://gist.github.com/jameskbride/5482722

>The babysitter 
- starts no earlier than 5:00PM
- leaves no later than 4:00AM
- gets paid $12/hour from start-time to bedtime
- gets paid $8/hour from bedtime to midnight
- gets paid $16/hour from midnight to end of job
- gets paid for full hours (no fractional hours)

>Feature:
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge


## How I Approached Testing/Coding ##

The babysitter has a unique rate of pay for each of 3 zones of time:
* Before bedtime
* Between bedtime and midnight
* After midnight

The babysitter does not bill fractional hours and is paid for the full hour:
* An end-time after the start of the hour is billed until the top of the next hour. (10:30 -> 11:00)
* A start time after the start of the hour is billed as if the start time was at the top of the hour. (7:30 -> 7:00)
* A bedtime that is not at the top of the hour is billed as if bedtime was at the top of the next hour. (8:30 -> 9:00)

The kata instructions do not have constraints for the bedtime; it may be determined differently by different clients (and is made part of the constructor).

Time inputs are based on a 24h clock (military time/"hundred hours"). This allows straightforward math operations of times and reduced ambiguity of AM/PM. (see below)

Code was produced using red-green-refactor TDD cycle. Refactoring was done to emphasize descriptive method names (rather than mathematical formulas) and named constants (vs "magic numbers"). The use of constants also permits the future changing of rates or times without having to change several lines of code. Code was also made more "DRY": using Math.min() and Math.max permitted simpler/fewer conditionals. Conversions were extracted into methods.

## Future Developments ##

The code takes advantage of having no fractional hours: it is coded as if there are 100 minutes in an hour. If the babysitter was to start pro-rating on fractional hours, there would have to be additional coding. Time logic could be encapsulated in an additional class. It could also be made more permissive with time inputs, such as allowing strings: "5:00 PM" would be as allowable as "1700".

Another change could be to validate the start and end times so that they are in the acceptable range (e.g. that start time must be 5:00 PM/1700 or later).


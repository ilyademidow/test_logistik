## Here is the test task to split the events ##

*Example:*
Before:
- Event A: 01.01.2000 - 18.01.2000
- Event B: 04.01.2000 - 11.01.2000
- Event C: 09.01.2000 - 13.01.2000
- Event D: 16.01.2000 - Inf

After:
- Event A: 01.01.2000 - 03.01.2000
- Event B: 04.01.2000 - 08.01.2000
- Event C: 09.01.2000 - 13.01.2000
- Event A: 14.01.2000 - 15.01.2000
- Event D: 16.01.2000 - Inf

### Conditions: ###
- Previous period begins early than the next period
- The end of the period greaters than start of this period
- The start of the period is number, can't be null
- Tag of period can't be null
- The next period has more priority than previous one

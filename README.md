# E-Commerce Project for LastMinute's interview

This is an exercise to implement the request logic as part of LastMinute hiring process.

## Description of the problem

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax applicable on all imported goods
at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price
(including tax), finishing with the total cost of the items, and the total amounts of sales taxes
paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.

## Configuration

All the required configuration is added to the code. Simply run:
	`gradle`
and the binaries will be created and tests executed

## Execution

For the purpose of the exercise, a `Main.java` file has been created and can be executed to get the required output

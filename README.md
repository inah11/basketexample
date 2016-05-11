# basketexample
This is just a simple example emulating the shopping basket. The application uses Java 8.

# assumptions
* Fruits can be purchased in Kilograms as well thats why I have used double as quantity

# design consideration
* The exercise has been done following strict TDD approach (expect couple of tests)
* All the classes are immutable; in case there is a need to add functionality to update the basket, copy the existing basket into the new one
* Enriched domain model has been used

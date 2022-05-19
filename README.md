# ShopifyBackendInternChallenge

User Guide of the application.

**Warehouses:**
- **create a warehouse** or multiple warehouses.
- All warehouses will be appeared in the item creation warehouse dropdown.
- All warehouses can also be seen in a tabl format.

**Items:**
- For creating an item. You definately need warehouses for sure. So please create warehouse before creating items.
- Create item by filling the given fields (All the fields are mandatory).
- **Once an Item is created** they can be seen in **inventory items list**.
- Each inventory item can either **deleted** or **edited**.
- **Item can be associated to a specific warehouse** while creating the item (can edit at later part also).

All the requirements are satisfied as per the requirements.

Note: Every time you restart the application, your previous data will be not be persisted (I have used h2 in-memory db. This can be altered to persisted the data or use mysql (or other DB's) if the scale of application is large).

**Steps to run the code:**
- Just run the code in the replit (it is a sping boot backend application). Always open the website in a new tab to see the proper working of the application (click on open website link). 
- Check above mentioned warehouse and items requirements.

**Technologies used:**
- Spring boot
- Thymeleaf
- h2
- html and css


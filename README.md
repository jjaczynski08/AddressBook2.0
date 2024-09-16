# AddressBook2.0
Description:
  Address Book is a program that organizes and stores contact information including name, phone number, and email. You are able to add a contact, view an alphabetical list of all contacts, search for a specific contact by name, edit any part of a contact’s information, delete a contact, or save your address book into a file (alphabetically sorted and CSV formatted). Command line arguments you can use are “-v”, “-a [fileToRead.txt]”, and “-s [fileToWrite.txt]”.

Known issues/improvements:
	You are able to add multiple contacts under the same name, phone and email - “edit” function merges them but I could instead merge it in the “add” function (might make more sense there). You are also able to add empty strings for name, phone, and email - doesn’t crash but would not happen realistically - could check in the “add” function. Lastly, you can’t manipulate contacts based off of the additional information (alt phone, alt email, address, birthday, social media profile). Therefore, if you have 2 contacts with the same name, phone, and email but different additional information, the program will still merge the two. This isn’t necessarily bad but it might be harmful depending on the client’s needs.

Collaborations:
Sam/Dad
Stack overflow

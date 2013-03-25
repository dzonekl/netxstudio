
Issues with encoding: 
- If you get this char: �

Use this regexp (in Jedit)

Replacing the first occurence in a line
^(\p{Blank})*�
«

Replacing the last occurence. 

�|-�
»

It will not fix all, so also 


- Carefull, this will skrew up the indentitation.

 
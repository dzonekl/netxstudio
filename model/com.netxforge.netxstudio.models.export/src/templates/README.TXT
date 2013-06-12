
Issues with encoding: 
- If you get this char: �

Use this regexp (in Jedit)

Replacing the first occurence in a line
^(\p{Blank})*�
«

Replacing the last ocurence. 

�|-�
»

It will not fix all, so also 


- Careful this will screw up the indenting.

 
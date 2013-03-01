NetXStudio UI Plugin
--------------------
Contains the Eclipse application, Menu, toolbars, perspectives, help. 

Note: We move away from editors as much as possible. 

- Editors limit the way we can layout the application. (Editor always in the middle). 
- Actionbar contributors, are hard to change (And very outdated paradigm), it's better to decouple all actions from the editors. 
- We really don't need an outline and properties view as we work with forms a lot. 

The alternative: 

- The functions of an editor, can be emulated with an IViewPart which implements ISaveable. 
- We provide a template IViewpart for this, which very much acts as an editor. 


TODO: 

- Abstract away the Role API, so we can remove dependency on IFixtures and IDataServices. 
- IFixtures defines the fixture roles.... 
- IDataServices reads the roles from the backend. 



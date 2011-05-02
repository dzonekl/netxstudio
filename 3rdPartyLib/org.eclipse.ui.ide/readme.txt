This is the original eclipse ui.ide plugin which we need to have some components working like xtext. 
This plugin drags in a lot of eclipse functionality which we don't need and wish to disable. 

- P2 dependency. 
	- Removed dependency to p2. (Modified class ConfigurationLogUpdateSection.java.
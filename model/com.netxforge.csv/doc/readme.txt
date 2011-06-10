The CSV Engine, provides a flexible way to import and export .CSV files. 
It has the following functionality: 

1. Registers an editor against the .csv file extension.

The Editor accepts an Editor input, which should contain a fileURI. The URI, is then 
passed to EditingDomain.resourceset.get(URI, boolean) to load the resource. 
A resource factory named: 

For this resourceset, we keep a separate Editing domain! (Pro's and cons to use our application domain). 

2. Defines a CSVResource which can load and save CSV file formats. 
The CSVResource uses an underlying load and save implementation. The Options for CSV loading and saving, 
are related to the options of CSV. 

These are: 

	public static final String EXCEL_NORTH_EUROPE_PREFERENCE = "EXCEL_NORTH_EUROPE_PREFERENCE";
	public static final String STANDARD_PREFERENCE = "STANDARD_PREFERENCE";
	public static final String EXCEL_PREFERENCE = "EXCEL_PREFERENCE";
	public static final String NO_COMMENT_PREFERENCE = "NO_COMMENT_PREFERENCE";

For Loading: 

Our CSVResource serializer uses Dynamic EMF to build a model based on the received CSV 
headers.

4. The editor, shows columns. 
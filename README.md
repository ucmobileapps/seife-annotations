# seife-annotations
Java source-level meta model for the seife annotation processor. 

## Static object model definition 
This library enables object description in a model driven designs. It allows to declare object relations and attribute bindings to fields.      

### Android

Use the model to create database wrappers with support for versioned upgrades and complete db-backed dataprovider implementations.

### Vaadin flow

Specify expressive mappings for vaadin flow forms and grid views with spring boot based JPA applications. 

## Further information on the model processor

* [Seife Annotation Processor](https://uc-mobileapps.com/seife-annotation-processor/) - the processor that uses this library

## Samples

### Android
Will create a language table with a combined primary key, will create BO class with cursor read and database insert/update,
will create peer classes for the database schema with support for versioned upgrades, will create a data provider class 'ShortcutProvider' implementation with 
a crud interface and selection logic for binding with the android UI:
```Java
@SeifeClass(sqlTablename="locale", generatorOptions={
    GeneratorOption.BOCLASS, 
    GeneratorOption.SCHEMA_PEER, 
    GeneratorOption.DATA_PROVIDER+"=ShortcutProvider"})
public class Language {

	@SeifeField(isPrimaryKey=true, sqlOptions=@SqlFieldOptions(sqlAutoIncrement=false, sqlColumn="_country"))
	private String countryId;
	@SeifeField(isPrimaryKey=true, sqlOptions=@SqlFieldOptions(sqlAutoIncrement=false, sqlColumn="_language"))
	private String languageId;

	@Id
	@Column(length=6)
	@SeifeField
	private String name;
	
	@Column(length=26)	
	private String description;

	@SeifeField
	private String flag;
  // [..]
}
```

### Vaadin 

Will automatically create a grid columns for all attributes annotated with @SeifeBinding: 
```Java
@SpringComponent
@Scope(SCOPE_PROTOTYPE)
@SeifeForm(forClass = Customer.class, generatorOptions = {
		GeneratorOption.VAADIN_GRID })
public class CustomerGrid extends Grid<Customer> implements I18nProvider {

	@SeifeBinding
	private Column<Customer> company;

	@SeifeBinding("address.phone")
	private Column<Customer> phone;
```
See the documentation in the processor for further usecases.

## Build the library

A gradle installation is needed to initially get the version this build is compatible with via the following command
```
gradle getwrapper
```

To create the artifact, use 
```
gradle clean build
```

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE](LICENSE) file for details

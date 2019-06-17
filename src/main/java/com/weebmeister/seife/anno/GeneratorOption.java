package com.weebmeister.seife.anno;

/**
 * Options for the source generator, not all options might be available in the licensed package.
 * @author Klaus Sausen
 */
public interface GeneratorOption {
	
	/** 
	 * Amends the BO-Class with additional convenience methods to e.g. resolve 1..n relations
	 */
	public static final String BOCLASS = "persistence.boClass";
	
	/** 
	 * Amends the BO-Class with additional convenience methods to e.g. resolve 1..n relations
	 * add a parcelable definition for each annotated field for IPC, see also {@link #BOPARCELABLE}
	 */
	public static final String BOCLASS_PARCELABLE = "persistence.boClassParcelable";

	/**
	 * Create a database schema peer class
	 */
	public static final String SCHEMA_PEER = "persistence.schemaPeer";

	/**
	 * Make BO part of an (Android-)DbHelper e.g.
	 * <pre> 
	 * DB_HELPER+"=com.weebmeister.seife.test.MyDbHelper"
	 * DB_HELPER+"=MyDbHelper" // uses the package defined in seife.package.persistence.dbHelper=
	 * </pre>
	 */
	public static final String DB_HELPER = "persistence.dbHelper";
	
	/**
	 * Implement the parcelable interface for all @SeifeField attributes for the BO 
	 */
	public static final String BOPARCELABLE = "ipc.parcelable";

	/**
	 * Make it part of a Dataprovider e.g.
	 * <pre> 
	 * DATA_PROVIDER+"=com.weebmeister.seife.test.MyProvider"
	 * DATA_PROVIDER+"=MyProvider" // uses the package defined in seife.package.provider.dataProvider=
	 * </pre>
	 */
	public static final String DATA_PROVIDER = "provider.dataProvider";
	
	/**
	 * Create a json capable export implementation 
	 */
	public static final String JSON_EXPORT = "json.export";
	
	/**
	 * Use this prefix in case your template is used as a merge generator
	 */
	public static final String MERGE_GENERATOR_PREFIX = "merge:";
	
	public class Util {
		/**
		 * Whether this merges several BOs into one output
		 * @param generatorOption the option to check, see e.g. {@link GeneratorOption#MERGE_GENERATOR_PREFIX}.
		 * @return true if an option was passed that is a  merge generator
		 */
		public static boolean isMergeGenerator(String generatorOption) {
			return generatorOption.startsWith(GeneratorOption.DATA_PROVIDER)
					|| generatorOption.startsWith(GeneratorOption.DB_HELPER)
					|| generatorOption.startsWith(GeneratorOption.JSON_EXPORT)
					|| generatorOption.startsWith(GeneratorOption.MERGE_GENERATOR_PREFIX);
		}

	}
}

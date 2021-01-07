package ptm.home.hibernate.naming;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import java.util.List;

public class HibernateCustomStrategy extends DelegatingReverseEngineeringStrategy {
	ReverseEngineeringStrategy delegate = null;

	public HibernateCustomStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);
		this.delegate = delegate;
	}

	@Override
	public String foreignKeyToEntityName(String keyname, TableIdentifier fromTable,
			@SuppressWarnings("rawtypes") List fromColumnNames, TableIdentifier referencedTable,
			@SuppressWarnings("rawtypes") List referencedColumnNames, boolean uniqueReference) {
		String col = super.foreignKeyToEntityName(keyname, fromTable, fromColumnNames, referencedTable,
				referencedColumnNames, uniqueReference);
		if (col.toLowerCase().endsWith("createdby")) {
			return "createdBy";
		} else if (col.toLowerCase().endsWith("updatedby")) {
			return "updatedBy";
		}
		return col;
	}

	/*
	 * @Override public String columnToPropertyName(TableIdentifier table, String
	 * column) { String col = delegate.columnToPropertyName(table, column); //
	 * String prop = delegate.tableToIdentifierPropertyName(table);
	 * System.out.println("table" + table.getName());
	 * 
	 * if (table.getCatalog().equals("ptm")) { if
	 * (table.getName().equals("employee")) { if (col.equals("enabled") ||
	 * col.equals("deleted")) { return "ActiveStatus"; } } }
	 * 
	 * return col; }
	 */

}

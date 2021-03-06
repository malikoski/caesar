package com.sirolf2009.caesar.model;

import com.sirolf2009.caesar.SerializationTest;
import com.sirolf2009.caesar.model.chart.series.IntegerSeries;
import com.sirolf2009.caesar.model.table.JMXAttribute;
import org.junit.Test;

import javax.management.MBeanAttributeInfo;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.FileNotFoundException;

public class CaesarModelTest {

	@Test
	public void test() throws MalformedObjectNameException, FileNotFoundException {
		CaesarModel model = new CaesarModel();

		JMXAttribute attribute1 = new JMXAttribute(new ObjectName("com.sirolf2009.test:Type=Unexisting1"), new MBeanAttributeInfo("name1", "int", "desc1", false, false, false));
		JMXAttribute attribute2 = new JMXAttribute(new ObjectName("com.sirolf2009.test:Type=Unexisting2"), new MBeanAttributeInfo("name1", "int", "desc1", false, false, false));
		Table table = new Table("table");
		table.getChildren().add(attribute1);
		table.getChildren().add(attribute2);
		model.getTables().add(table);

		Chart chart = new Chart("series");
		chart.getChildren().add(new ColumnOrRow.Column(new IntegerSeries(table, attribute1)));
		chart.getChildren().add(new ColumnOrRow.Row(new IntegerSeries(table, attribute2)));
		model.getCharts().add(chart);

		SerializationTest.testCloning(model, CaesarModel.class);
	}

}

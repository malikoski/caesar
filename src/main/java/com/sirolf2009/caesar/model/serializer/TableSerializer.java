package com.sirolf2009.caesar.model.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.sirolf2009.caesar.model.JMXAttribute;
import com.sirolf2009.caesar.model.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TableSerializer extends CaesarSerializer<Table> {

	@Override public void write(Kryo kryo, Output output, Table table) {
		output.writeString(table.getName());
		writeObservableList(kryo, output, table.getChildren());
	}

	@Override public Table read(Kryo kryo, Input input, Class<Table> type) {
		SimpleStringProperty name = readStringProperty(input);
		ObservableList<JMXAttribute> attributes = readObservableList(kryo, input, JMXAttribute.class);
		return new Table(name, attributes, FXCollections.observableArrayList());
	}
}
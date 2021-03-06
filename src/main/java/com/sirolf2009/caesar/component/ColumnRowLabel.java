package com.sirolf2009.caesar.component;

import com.sirolf2009.caesar.util.ControllerUtil;
import com.sirolf2009.caesar.model.chart.series.ISeries;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ColumnRowLabel extends HBox {

    private final ISeries series;

    @FXML
    Label txtObjectName;
    @FXML
    Button btnRemove;

    public ColumnRowLabel(ISeries series) {
        this.series = series;
        ControllerUtil.load(this, "/fxml/column-row-label.fxml");
    }

    @FXML
    public void initialize() {
        txtObjectName.setText(series.getTable().getName()+"/"+series.getAttribute().toString());
    }

    public Button getBtnRemove() {
        return btnRemove;
    }
}

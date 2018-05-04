/*******************************************************************************
 * Copyright (c) 2017, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.jsf23.fat.datamodel;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.FacesDataModel;

/**
 * A DataModel implementation for TestValuesChild. The class is annotated
 * RequestScoped so we don't need a beans.xml in the application.
 *
 * In addition getRowData() will prepend "child: " to each value so we know this
 * specific DataModel was being used.
 */
@RequestScoped
@FacesDataModel(forClass = TestValuesChild.class)
public class TestValuesChildDataModel extends DataModel<Object> {

    TestValuesChild values;
    int testValueIndex = 0;

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return 4;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#getRowData()
     */
    @Override
    public Object getRowData() {
        Object retValue = null;
        switch (testValueIndex) {
            case 0:
                retValue = "child: " + values.getTestValue1();
                break;

            case 1:
                retValue = "child: " + values.getTestValue2();
                break;

            case 2:
                retValue = "child: " + values.getTestValue3();
                break;

            case 3:
                retValue = "child: " + values.getTestValue4();
                break;
        }

        return retValue;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#getRowIndex()
     */
    @Override
    public int getRowIndex() {
        return testValueIndex;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#getWrappedData()
     */
    @Override
    public Object getWrappedData() {
        return values;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#isRowAvailable()
     */
    @Override
    public boolean isRowAvailable() {

        boolean retVal = false;

        if (testValueIndex < 4) {
            retVal = true;
        }

        return retVal;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#setRowIndex(int)
     */
    @Override
    public void setRowIndex(int arg0) {
        testValueIndex = arg0;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.faces.model.DataModel#setWrappedData(java.lang.Object)
     */
    @Override
    public void setWrappedData(Object arg0) {
        values = (TestValuesChild) arg0;
    }

}

package uk.ac.reading.cs.knime.kmeans;

import org.knime.core.data.DoubleValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnFilter;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelFilterString;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;

/**
 * <code>NodeDialog</code> for the "KMeansWSS" Node.
 * Implementation of the k-Means clustering algorithm returning the validity measure WSS and BSS.
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author Giuseppe Di Fatta
 */
public class KMeansWSSNodeDialog extends DefaultNodeSettingsPane {

    /**
     * Constructor - set name of k-means cluster node. Also initialize special
     * property panel holding the variables that can be adjusted by the user.
     */
    @SuppressWarnings("unchecked")
    KMeansWSSNodeDialog() {
        super();
        SettingsModelIntegerBounded smib = new SettingsModelIntegerBounded(
        		KMeansWSSNodeModel.CFG_NR_OF_CLUSTERS,
        		KMeansWSSNodeModel.INITIAL_NR_CLUSTERS,
                1, Integer.MAX_VALUE);
        DialogComponentNumber nrOfClusters = new DialogComponentNumber(
            smib, "number of clusters: ", 1, createFlowVariableModel(smib));
        DialogComponentNumber maxNrOfIterations = new DialogComponentNumber(
                new SettingsModelIntegerBounded(
                		KMeansWSSNodeModel.CFG_MAX_ITERATIONS,
                		KMeansWSSNodeModel.INITIAL_MAX_ITERATIONS,
                        1, Integer.MAX_VALUE),
                        "max. number of iterations: ", 10);
        DialogComponentColumnFilter columnFilter = new DialogComponentColumnFilter(
                new SettingsModelFilterString(KMeansWSSNodeModel.CFG_COLUMNS),
                0, true, DoubleValue.class);
        DialogComponentBoolean enableHilite = new DialogComponentBoolean(
            new SettingsModelBoolean(KMeansWSSNodeModel.CFG_ENABLE_HILITE, false),
            "Enable Hilite Mapping");

        addDialogComponent(nrOfClusters);
        addDialogComponent(maxNrOfIterations);
        addDialogComponent(columnFilter);
        addDialogComponent(enableHilite);
        setDefaultTabTitle("K-Means Properties");
    }
}


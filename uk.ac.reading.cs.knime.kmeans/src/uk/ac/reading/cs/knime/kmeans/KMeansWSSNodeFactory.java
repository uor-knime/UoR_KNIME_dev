package uk.ac.reading.cs.knime.kmeans;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KMeansWSS" Node.
 * Implementation of the k-Means clustering algorithm returning the validity measure WSS and BSS.
 *
 * @author Giuseppe Di Fatta
 */
public class KMeansWSSNodeFactory 
        extends NodeFactory<KMeansWSSNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KMeansWSSNodeModel createNodeModel() {
        return new KMeansWSSNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeView<KMeansWSSNodeModel> createNodeView(final int viewIndex,
            final KMeansWSSNodeModel nodeModel) {
        if (viewIndex != 0) {
            throw new IllegalStateException();
        }
        return new KMeansWSSNodeView(nodeModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasDialog() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeDialogPane createNodeDialogPane() {
        return new KMeansWSSNodeDialog();
    }

}


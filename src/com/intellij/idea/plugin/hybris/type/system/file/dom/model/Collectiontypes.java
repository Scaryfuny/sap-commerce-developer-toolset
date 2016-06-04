// Generated on Sun Jun 05 01:21:13 EEST 2016
// DTD/Schema  :    null

package com.intellij.idea.plugin.hybris.type.system.file.dom.model;

import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.SubTagList;
import org.jetbrains.annotations.NotNull;

/**
 * null:collectiontypesType interface.
 * <pre>
 * <h3>Type null:collectiontypesType documentation</h3>
 * Defines a list of collection types.
 * </pre>
 */
public interface CollectionTypes extends DomElement {

    /**
     * Returns the list of collectiontype children.
     * <pre>
     * <h3>Element null:collectiontype documentation</h3>
     * A CollectionType defines a collection of typed elements.
     * </pre>
     *
     * @return the list of collectiontype children.
     */
    @NotNull
    @SubTagList("collectiontype")
    java.util.List<CollectionType> getCollectionTypes();

    /**
     * Adds new child to the list of collectiontype children.
     *
     * @return created child
     */
    @SubTagList("collectiontype")
    CollectionType addCollectionType();


}

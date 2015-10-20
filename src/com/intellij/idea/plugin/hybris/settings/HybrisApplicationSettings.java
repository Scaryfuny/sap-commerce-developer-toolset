/*
 * This file is part of "Hybris Integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2015 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.settings;

import com.google.common.collect.Lists;
import com.intellij.ide.util.PropertyName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class HybrisApplicationSettings {

    public static final List<String> DEFAULT_JUNK_FILE_NAMES = Lists.newArrayList(
        ".classpath",
        ".directory",
        ".externalToolBuilders",
        ".idea",
        ".pmd",
        ".project",
        ".ruleset",
        ".settings",
        ".springBeans",
        "beans.xsd",
        "classes",
        "eclipsebin",
        "extensioninfo.xsd",
        "items.xsd",
        "platformhome.properties",
        "ruleset.xml",
        "testclasses"
    );

    @PropertyName("foldingEnabled")
    private boolean foldingEnabled = true;

    @PropertyName("useSmartFolding")
    private boolean useSmartFolding = true;

    @PropertyName("limitedSpringConfig")
    private boolean limitedSpringConfig = true;

    @PropertyName("groupModules")
    private boolean groupModules = true;

    @PropertyName("junkDirectoryList")
    private List<String> junkDirectoryList = DEFAULT_JUNK_FILE_NAMES;

    @PropertyName("groupHybris")
    private String groupHybris = "Hybris";

    @PropertyName("groupOtherHybris")
    private String groupOtherHybris = "Hybris/Unused";

    @PropertyName("groupCustom")
    private String groupCustom = "Custom";

    @PropertyName("groupOtherCustom")
    private String groupOtherCustom = "Custom/Unused";

    @PropertyName("jRebelOutputPath")
    private boolean jRebelOutputPath;


    public HybrisApplicationSettings() {
    }

    public boolean isFoldingEnabled() {
        return foldingEnabled;
    }

    public void setFoldingEnabled(final boolean foldingEnabled) {
        this.foldingEnabled = foldingEnabled;
    }

    public boolean isUseSmartFolding() {
        return useSmartFolding;
    }

    public void setUseSmartFolding(final boolean foldingEnabled) {
        this.useSmartFolding = foldingEnabled;
    }

    public boolean isLimitedSpringConfig() {
        return limitedSpringConfig;
    }

    public void setLimitedSpringConfig(final boolean limitedSpringConfig) {
        this.limitedSpringConfig = limitedSpringConfig;
    }

    public List<String> getJunkDirectoryList() {
        return junkDirectoryList;
    }

    public void setJunkDirectoryList(final List<String> junkDirectoryList) {
        this.junkDirectoryList = junkDirectoryList;
    }

    public void setGroupModules(final boolean groupModules) {
        this.groupModules = groupModules;
    }

    public boolean isGroupModules() {
        return groupModules;
    }

    public String getGroupHybris() {
        return groupHybris;
    }

    public void setGroupHybris(final String groupHybris) {
        this.groupHybris = groupHybris;
    }

    public String getGroupOtherHybris() {
        return groupOtherHybris;
    }

    public void setGroupOtherHybris(final String groupOtherHybris) {
        this.groupOtherHybris = groupOtherHybris;
    }

    public String getGroupCustom() {
        return groupCustom;
    }

    public void setGroupCustom(final String groupCustom) {
        this.groupCustom = groupCustom;
    }

    public String getGroupOtherCustom() {
        return groupOtherCustom;
    }

    public void setGroupOtherCustom(final String groupOtherCustom) {
        this.groupOtherCustom = groupOtherCustom;
    }

    public boolean isJRebelOutputPath() {
        return jRebelOutputPath;
    }

    public void setJRebelOutputPath(final boolean jRebelOutputPath) {
        this.jRebelOutputPath = jRebelOutputPath;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || getClass() != obj.getClass()) {
            return false;
        }

        final HybrisApplicationSettings other = (HybrisApplicationSettings) obj;

        return new EqualsBuilder()
            .append(foldingEnabled, other.foldingEnabled)
            .append(useSmartFolding, other.useSmartFolding)
            .append(limitedSpringConfig, other.limitedSpringConfig)
            .append(groupModules, other.groupModules)
            .append(junkDirectoryList, other.junkDirectoryList)
            .append(groupHybris, other.groupHybris)
            .append(groupOtherHybris, other.groupOtherHybris)
            .append(groupCustom, other.groupCustom)
            .append(groupOtherCustom, other.groupOtherCustom)
            .append(jRebelOutputPath, other.jRebelOutputPath)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(foldingEnabled)
            .append(useSmartFolding)
            .append(limitedSpringConfig)
            .append(groupModules)
            .append(junkDirectoryList)
            .append(groupHybris)
            .append(groupOtherHybris)
            .append(groupCustom)
            .append(groupOtherCustom)
            .append(jRebelOutputPath)
            .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HybrisApplicationSettings{");
        sb.append("foldingEnabled=").append(foldingEnabled);
        sb.append(", useSmartFolding=").append(useSmartFolding);
        sb.append(", limitedSpringConfig=").append(limitedSpringConfig);
        sb.append(", groupModules=").append(groupModules);
        sb.append(", junkDirectoryList=").append(junkDirectoryList);
        sb.append(", groupHybris='").append(groupHybris).append('\'');
        sb.append(", groupOtherHybris='").append(groupOtherHybris).append('\'');
        sb.append(", groupCustom='").append(groupCustom).append('\'');
        sb.append(", groupOtherCustom='").append(groupOtherCustom).append('\'');
        sb.append(", jRebelOutputPath='").append(jRebelOutputPath).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
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

package com.intellij.idea.plugin.hybris.project.configurators;

import com.intellij.facet.*;
import com.intellij.idea.plugin.hybris.project.settings.HybrisModuleDescriptor;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.spring.facet.SpringFacet;
import com.intellij.spring.facet.SpringFileSet;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Created by Martin Zdarsky (martin.zdarsky@hybris.com) on 7/08/15.
 */
public class DefaultFacetConfigurator implements FacetConfigurator {

    @Override
    public void configure(@NotNull final ModifiableFacetModel modifiableFacetModel,
                          @NotNull final HybrisModuleDescriptor moduleDescriptor,
                          @NotNull final Module javaModule) {

        Validate.notNull(javaModule);
        Validate.notNull(modifiableFacetModel);
        Validate.notNull(moduleDescriptor);

        ApplicationManager.getApplication().runWriteAction(new Runnable() {
            @Override
            public void run() {
                configureInner(modifiableFacetModel, moduleDescriptor, javaModule);
            }
        });
    }

    protected void configureInner(@NotNull final ModifiableFacetModel modifiableFacetModel,
                                  @NotNull final HybrisModuleDescriptor moduleDescriptor,
                                  @NotNull final Module javaModule) {

        configureSpringFacet(javaModule, modifiableFacetModel, moduleDescriptor);

        modifiableFacetModel.commit();
    }


    private void configureSpringFacet(@NotNull final Module javaModule,
                                      @NotNull final ModifiableFacetModel modifiableFacetModel,
                                      @NotNull final HybrisModuleDescriptor moduleDescriptor) {
        Validate.notNull(javaModule);
        Validate.notNull(modifiableFacetModel);
        Validate.notNull(moduleDescriptor);

        SpringFacet springFacet = modifiableFacetModel.getFacetByType(SpringFacet.FACET_TYPE_ID);

        if (springFacet == null) {
            FacetType springFacetType = FacetTypeRegistry.getInstance().findFacetType(SpringFacet.FACET_TYPE_ID);
            springFacet = (SpringFacet) springFacetType.createFacet(javaModule, SpringFacet.FACET_TYPE_ID.toString(),
                                                                    springFacetType.createDefaultConfiguration(), null);
            modifiableFacetModel.addFacet(springFacet);
        } else {
            springFacet.removeFileSets();
        }

        final String facetId = moduleDescriptor.getName() + SpringFacet.FACET_TYPE_ID.toString();
        final SpringFileSet springFileSet = springFacet.addFileSet(facetId, facetId);
        for (String springFile: moduleDescriptor.getSpringFileSet()) {
            final VirtualFile vf = VfsUtil.findFileByIoFile(new File(springFile), true);
            springFileSet.addFile(vf);
        }
    }
}
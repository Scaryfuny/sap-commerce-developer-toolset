package com.intellij.idea.plugin.hybris.project.settings;

import com.google.common.collect.Sets;
import com.intellij.idea.plugin.hybris.project.exceptions.HybrisConfigurationException;
import com.intellij.idea.plugin.hybris.utils.HybrisConstants;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collections;
import java.util.Set;

/**
 * Created 3:55 PM 13 June 2015.
 *
 * @author Alexander Bartash <AlexanderBartash@gmail.com>
 */
public class PlatformHybrisModuleDescriptor extends AbstractHybrisModuleDescriptor {

    public PlatformHybrisModuleDescriptor(@NotNull final File moduleRootDirectory) throws HybrisConfigurationException {
        super(moduleRootDirectory);
    }

    @NotNull
    @Override
    public String getModuleName() {
        return HybrisConstants.PLATFORM_EXTENSION_NAME;
    }

    @NotNull
    @Override
    public Set<String> getRequiredExtensionNames() {
        return Collections.unmodifiableSet(Sets.newHashSet(
            HybrisConstants.CONFIG_EXTENSION_NAME
        ));
    }
}
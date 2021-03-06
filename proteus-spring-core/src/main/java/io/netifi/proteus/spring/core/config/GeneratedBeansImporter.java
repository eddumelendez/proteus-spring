/**
 * Copyright 2018 Netifi Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.netifi.proteus.spring.core.config;

import io.rsocket.rpc.annotations.internal.Generated;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

public class GeneratedBeansImporter implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(
        AnnotationMetadata importMetadata,
        BeanDefinitionRegistry registry
    ) {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner( registry, false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Generated.class));
        scanner.scan(ClassUtils.getPackageName(importMetadata.getClassName()));
    }
}

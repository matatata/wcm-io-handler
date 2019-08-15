/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.handler.link;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.annotation.versioning.ProviderType;

import io.wcm.handler.commons.dom.Anchor;
import io.wcm.handler.url.UrlMode;

/**
 * Define link handling request using builder pattern.
 */
@ProviderType
public interface LinkBuilder {

  /**
   * Set link arguments
   * @param linkArgs Link arguments
   * @return Link builder
   */
  @NotNull
  LinkBuilder args(@NotNull LinkArgs linkArgs);

  /**
   * Set selectors
   * @param selectors Selector string
   * @return Link builder
   */
  @NotNull
  LinkBuilder selectors(@Nullable String selectors);

  /**
   * Set file extension
   * @param extension File extension
   * @return Link builder
   */
  @NotNull
  LinkBuilder extension(@Nullable String extension);

  /**
   * Set suffix
   * @param suffix Suffix string
   * @return Link builder
   */
  @NotNull
  LinkBuilder suffix (@Nullable String suffix);

  /**
   * Set query parameters string
   * @param queryString Query parameters string (properly url-encoded)
   * @return Link builder
   */
  @NotNull
  LinkBuilder queryString(@Nullable String queryString);

  /**
   * Set fragment identifier
   * @param fragment Fragment identifier
   * @return Link builder
   */
  @NotNull
  LinkBuilder fragment(@Nullable String fragment);

  /**
   * Set URL mode for externalizing the URL
   * @param urlMode URL mode. If null, default URL mode is used.
   * @return Link builder
   */
  @NotNull
  LinkBuilder urlMode(@Nullable UrlMode urlMode);

  /**
   * @param value If set to true, link handler returns a dummy link in edit mode when link is invalid.
   * @return this
   */
  @NotNull
  LinkBuilder dummyLink(boolean value);

  /**
   * @param value Custom dummy link url. If null default dummy url is used.
   * @return this
   */
  @NotNull
  LinkBuilder dummyLinkUrl(@Nullable String value);

  /**
   * Defines a "fallback" property name that is used to load link target information from a single property
   * instead of the link type + link type depending property name. This property is used for migration
   * from components that do not support Link Handler. It is only used for reading, and never written back to.
   * When opened and saved in the link dialog, the property is removed and instead the dedicated properties are used.
   * @param propertyName Property name
   * @return this
   */
  @NotNull
  LinkBuilder linkTargetUrlFallbackProperty(@Nullable String propertyName);

  /**
   * Resolve link and return metadata object that contains the results.
   * @return Link metadata object. Never null, if the resolving failed the isValid() method returns false.
   */
  @NotNull
  Link build();

  /**
   * Resolve link and return directly the markup generated by the link markup builder.
   * @return Link markup (only the opening anchor tag) or null if resolving was not successful.
   */
  @Nullable
  String buildMarkup();

  /**
   * Resolve link and return directly the markup as DOM element generated by the link markup builder.
   * @return Link markup or null if resolving was not successful.
   */
  @Nullable
  Anchor buildAnchor();

  /**
   * Resolve link and get URL.
   * @return Link URL or null if resolving was not successful.
   */
  @Nullable
  String buildUrl();

}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/recipes.proto

package service;

public interface RecipeViewRespOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.RecipeViewResp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <code>repeated .services.RecipeEntry recipes = 2;</code>
   */
  java.util.List<service.RecipeEntry> 
      getRecipesList();
  /**
   * <code>repeated .services.RecipeEntry recipes = 2;</code>
   */
  service.RecipeEntry getRecipes(int index);
  /**
   * <code>repeated .services.RecipeEntry recipes = 2;</code>
   */
  int getRecipesCount();
  /**
   * <code>repeated .services.RecipeEntry recipes = 2;</code>
   */
  java.util.List<? extends service.RecipeEntryOrBuilder> 
      getRecipesOrBuilderList();
  /**
   * <code>repeated .services.RecipeEntry recipes = 2;</code>
   */
  service.RecipeEntryOrBuilder getRecipesOrBuilder(
      int index);

  /**
   * <pre>
   * only given when isSuccess is false
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * only given when isSuccess is false
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}

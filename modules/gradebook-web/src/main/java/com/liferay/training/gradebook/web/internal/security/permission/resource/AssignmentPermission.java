package com.liferay.training.gradebook.web.internal.security.permission.resource;

 import com.liferay.portal.kernel.exception.PortalException;
 import com.liferay.portal.kernel.security.permission.PermissionChecker;
 import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
 import com.liferay.training.gradebook.model.Assignment;

 import org.osgi.service.component.annotations.Component;
 import org.osgi.service.component.annotations.Reference;

 /**
  * @author liferay
  */
 @Component(
     immediate = true, 
     service = AssignmentPermission.class
 )
 public class AssignmentPermission {

     public static boolean contains(
             PermissionChecker permissionChecker, Assignment assignment,
             String actionId)
         throws PortalException {

         return _assignmentModelResourcePermission.contains(
             permissionChecker, assignment, actionId);
     }

     public static boolean contains(
             PermissionChecker permissionChecker, long assignmentId, String actionId)
         throws PortalException {

         return _assignmentModelResourcePermission.contains(
             permissionChecker, assignmentId, actionId);
     }

     @Reference(
         target = "(model.class.name=com.liferay.training.gradebook.model.Assignment)",
         unbind = "-"
     )
     protected void setEntryModelPermission(
         ModelResourcePermission<Assignment> modelResourcePermission) {

         _assignmentModelResourcePermission = modelResourcePermission;
     }

     private static ModelResourcePermission<Assignment>
     _assignmentModelResourcePermission;

 }
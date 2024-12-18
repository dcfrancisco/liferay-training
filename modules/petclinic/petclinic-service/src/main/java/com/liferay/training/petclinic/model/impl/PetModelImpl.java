/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.training.petclinic.model.Pet;
import com.liferay.training.petclinic.model.PetModel;
import com.liferay.training.petclinic.model.PetSoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Pet service. Represents a row in the &quot;PetClinic_Pet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PetModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetImpl
 * @generated
 */
@JSON(strict = true)
public class PetModelImpl extends BaseModelImpl<Pet> implements PetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pet model instance should use the <code>Pet</code> interface instead.
	 */
	public static final String TABLE_NAME = "PetClinic_Pet";

	public static final Object[][] TABLE_COLUMNS = {
		{"petId", Types.BIGINT}, {"ownerId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"birthDate", Types.TIMESTAMP},
		{"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("petId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ownerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PetClinic_Pet (petId LONG not null primary key,ownerId LONG,name VARCHAR(75) null,birthDate DATE null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PetClinic_Pet";

	public static final String ORDER_BY_JPQL = " ORDER BY pet.petId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PetClinic_Pet.petId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OWNERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PETID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Pet toModel(PetSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Pet model = new PetImpl();

		model.setPetId(soapModel.getPetId());
		model.setOwnerId(soapModel.getOwnerId());
		model.setName(soapModel.getName());
		model.setBirthDate(soapModel.getBirthDate());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Pet> toModels(PetSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Pet> models = new ArrayList<Pet>(soapModels.length);

		for (PetSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _petId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _petId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Pet.class;
	}

	@Override
	public String getModelClassName() {
		return Pet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Pet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Pet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Pet, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Pet)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Pet, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Pet, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Pet)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Pet, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Pet, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Pet, Object>>
		_attributeGetterFunctions;

	static {
		Map<String, Function<Pet, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Pet, Object>>();

		attributeGetterFunctions.put("petId", Pet::getPetId);
		attributeGetterFunctions.put("ownerId", Pet::getOwnerId);
		attributeGetterFunctions.put("name", Pet::getName);
		attributeGetterFunctions.put("birthDate", Pet::getBirthDate);
		attributeGetterFunctions.put("type", Pet::getType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
	}

	private static final Map<String, BiConsumer<Pet, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, BiConsumer<Pet, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Pet, ?>>();

		attributeSetterBiConsumers.put(
			"petId", (BiConsumer<Pet, Long>)Pet::setPetId);
		attributeSetterBiConsumers.put(
			"ownerId", (BiConsumer<Pet, Long>)Pet::setOwnerId);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Pet, String>)Pet::setName);
		attributeSetterBiConsumers.put(
			"birthDate", (BiConsumer<Pet, Date>)Pet::setBirthDate);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<Pet, String>)Pet::setType);

		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPetId() {
		return _petId;
	}

	@Override
	public void setPetId(long petId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_petId = petId;
	}

	@JSON
	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ownerId = ownerId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOwnerId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("ownerId"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthDate = birthDate;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Pet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Pet toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Pet> escapedModelProxyProviderFunction =
				EscapedModelProxyProviderFunctionHolder.
					_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PetImpl petImpl = new PetImpl();

		petImpl.setPetId(getPetId());
		petImpl.setOwnerId(getOwnerId());
		petImpl.setName(getName());
		petImpl.setBirthDate(getBirthDate());
		petImpl.setType(getType());

		petImpl.resetOriginalValues();

		return petImpl;
	}

	@Override
	public int compareTo(Pet pet) {
		long primaryKey = pet.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Pet)) {
			return false;
		}

		Pet pet = (Pet)object;

		long primaryKey = pet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Pet> toCacheModel() {
		PetCacheModel petCacheModel = new PetCacheModel();

		petCacheModel.petId = getPetId();

		petCacheModel.ownerId = getOwnerId();

		petCacheModel.name = getName();

		String name = petCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			petCacheModel.name = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			petCacheModel.birthDate = birthDate.getTime();
		}
		else {
			petCacheModel.birthDate = Long.MIN_VALUE;
		}

		petCacheModel.type = getType();

		String type = petCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			petCacheModel.type = null;
		}

		return petCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Pet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Pet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Pet, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Pet)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Pet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Pet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Pet, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Pet)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Pet>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Pet.class, ModelWrapper.class);

	}

	private long _petId;
	private long _ownerId;
	private String _name;
	private Date _birthDate;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Pet, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Pet)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("petId", _petId);
		_columnOriginalValues.put("ownerId", _ownerId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("birthDate", _birthDate);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("type_", "type");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("petId", 1L);

		columnBitmasks.put("ownerId", 2L);

		columnBitmasks.put("name", 4L);

		columnBitmasks.put("birthDate", 8L);

		columnBitmasks.put("type_", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Pet _escapedModel;

}
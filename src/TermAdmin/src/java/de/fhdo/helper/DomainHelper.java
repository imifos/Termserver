/* 
 * CTS2 based Terminology Server and Terminology Browser
 * Copyright (C) 2014 FH Dortmund: Peter Haas, Robert Muetzner
 *
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
 */
package de.fhdo.helper;

import de.fhdo.terminologie.db.Definitions;
import de.fhdo.terminologie.db.hibernate.Domain;
import de.fhdo.terminologie.db.hibernate.DomainValue;
import de.fhdo.terminologie.db.HibernateUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.cfg.NotYetImplementedException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;
import org.zkoss.zul.RadioRenderer;
import org.zkoss.zul.Radiogroup;

/**
 *
 * @author Robert Mützner
 */
public class DomainHelper
{

  private static org.apache.log4j.Logger logger = de.fhdo.logging.Logger4j.getInstance().getLogger();
  // Singleton-Muster
  private static DomainHelper instance;

  public static DomainHelper getInstance()
  {
    if (instance == null)
      instance = new DomainHelper();

    return instance;
  }
  // Klasse
  private Map<Long, Map<String, DomainValue>> domains = null;
  private Map<Long, List<DomainValue>> domainLists = null;
  private Map<Long, DomainValue> defaultValues = null;

  public DomainHelper()
  {
  }

  public void reloadAllDomains()
  {
    domains = null;
    domainLists = null;
    defaultValues = null;
  }

  /**
   * Liest eine DomainValue aus einer Domäne mit dem angegebenen Code
   *
   * @param DomainID Die zu lesende DomainID, siehe Definitions.java
   * @param Code Der zu lesende Code
   * @return die DomainValue
   */
  public DomainValue getDomainValue(long DomainID, String Code)
  {
    if (Code == null || Code.length() == 0)
      return null;

    DomainValue dv = null;
    initDomain(DomainID);

    Map<String, DomainValue> map = getDomainMap(DomainID);

    if (map != null)
    {
      dv = map.get(Code);
    }

    if (dv == null && logger.isDebugEnabled())
      logger.debug("DomainValue mit Domain-ID " + DomainID + " und Code '" + Code + "' nicht gefunden!");

    return dv;
  }

  /**
   * Liest eine DomainValue aus einer Domäne mit dem angegebenen Code
   *
   * @param DomainValueID Die zu lesende DomainID, siehe Definitions.java
   * @return die DomainValue
   */
  public DomainValue getDomainValue(long DomainValueID)
  {
    if (DomainValueID <= 0)
      return null;

    DomainValue dv = null;
    //initDomain(DomainID);

    Session hb_session = HibernateUtil.getSessionFactory().openSession();
    //hb_session.getTransaction().begin();

    dv = (DomainValue) hb_session.get(DomainValue.class, DomainValueID);

    // Transaktion abschließen
    
    hb_session.close();

    if (dv == null && logger.isDebugEnabled())
      logger.debug("DomainValue mit ID '" + DomainValueID + "' nicht gefunden!");

    return dv;
  }

  public String getDomainValueDisplayText(long DomainID, String Code)
  {
    if (Code == null || Code.length() == 0)
      return "";

    DomainValue dv = null;
    initDomain(DomainID);

    Map<String, DomainValue> map = getDomainMap(DomainID);

    if (map != null)
    {
      dv = map.get(Code);
    }

    if (dv == null)
    {
      if (logger.isDebugEnabled())
        logger.debug("DomainValue mit Domain-ID " + DomainID + " und Code '" + Code + "' nicht gefunden!");

      return "";
    }

    return dv.getDomainDisplay();
  }

  /**
   * Liest alle übergeordneten DomainValues zu einer DomainValue
   *
   */
  public List<DomainValue> getUpperDomainValues(long DomainValueID)
  {
    if (DomainValueID <= 0)
      return null;

    DomainValue dv = null;
    //initDomain(DomainID);

    Session hb_session = HibernateUtil.getSessionFactory().openSession();
    //hb_session.getTransaction().begin();

    dv = (DomainValue) hb_session.get(DomainValue.class, DomainValueID);
    if (dv == null && logger.isDebugEnabled())
      logger.debug("DomainValue mit ID '" + DomainValueID + "' nicht gefunden!");

    List<DomainValue> list = null;
    if (dv != null && dv.getDomainValuesForDomainValueId1() != null)
    {
      list = new LinkedList(dv.getDomainValuesForDomainValueId1());
    }

    // Transaktion abschließen
    
    hb_session.close();

    return list;
  }

  /**
   * Liest alle übergeordneten DomainValues zu einer DomainValue
   *
   */
  public boolean saveUpperDomainID(long DomainValueID, long UpperID)
  {
    if (DomainValueID <= 0)
      return false;

    logger.debug("saveUpperDomainID mit '" + DomainValueID + "' und " + UpperID);

    DomainValue dv = null;
    //initDomain(DomainID);

    DomainValue ueber_dv = getDomainValue(UpperID);

    if (ueber_dv == null)
    {
      logger.debug("DomainValue mit Über-ID " + UpperID + " existiert nicht");
      return false;
    }

    Session hb_session = HibernateUtil.getSessionFactory().openSession();
    hb_session.getTransaction().begin();

    dv = (DomainValue) hb_session.get(DomainValue.class, DomainValueID);
    if (dv == null && logger.isDebugEnabled())
      logger.debug("DomainValue mit ID '" + DomainValueID + "' nicht gefunden!");

    //List<DomainValue> list = null;
    if (dv != null)
    {
      boolean gefunden = false;
      if (dv.getDomainValuesForDomainValueId1() != null)
      {
        Iterator<DomainValue> it = dv.getDomainValuesForDomainValueId1().iterator();
        while (it.hasNext())
        {
          DomainValue ueber_dv2 = it.next();
          if (ueber_dv2.getDomainValueId() == UpperID)
          {
            logger.debug("Über-Domain bereits gefunden, also nicht hinzufügen");
            gefunden = true;
          }
        }
      }

      if (gefunden == false)
      {
        logger.debug("Über-Domain hinzufügen...");

        if (dv.getDomainValuesForDomainValueId1() == null)
          dv.setDomainValuesForDomainValueId1(new HashSet<DomainValue>());

        dv.getDomainValuesForDomainValueId1().add(ueber_dv);

        hb_session.merge(dv);
      }
      //list = new LinkedList(dv.getDomainValuesForDomainValueId1());
    }

    // Transaktion abschließen
    hb_session.getTransaction().commit();
    hb_session.close();

    return true;
  }

  /**
   * Liest eine Map von DomainValues anhand einer DomainID. Wurde die Liste
   * bereits gelesen, wird die gespeicherte zurückgegeben.
   *
   * @param DomainID Die zu lesende DomainID, siehe Definitions.java
   * @return Map von DomainValues, welche zu der Domäne gehören
   */
  public Map<String, DomainValue> getDomainMap(long DomainID)
  {
    initDomain(DomainID);

    return domains.get(DomainID);
  }

  public List<DomainValue> getDomainList(long DomainID)
  {
    initDomain(DomainID);

    return domainLists.get(DomainID);
  }

  public DomainValue getDefaultValue(long DomainID)
  {
    return defaultValues.get(DomainID);
  }

  public String[] getDomainStringList(long DomainID)
  {
    initDomain(DomainID);

    String[] s = null;
    try
    {
      List<DomainValue> dvList = domainLists.get(DomainID);

      s = new String[dvList.size()];
      
      for(int i=0;i<dvList.size();++i)
      {
        s[i] = dvList.get(i).getDomainDisplay();
      }

    }
    catch (Exception ex)
    {
      logger.error("[DomainHelper.java] Fehler bei getDomainStringList(): " + ex.getLocalizedMessage());
    }

    return s;
  }

  /**
   * Löscht eine zwischengespeicherte Domain-Liste. Beim nächsten Aufruf von
   * getDomainMap() wird die Liste erneut geladen!
   *
   * @param DomainID Die zu löschende DomainID, siehe Definitions.java
   */
  public void reloadDomain(long DomainID)
  {
    if (domains != null)
    {
      if (logger.isDebugEnabled())
        logger.debug("entferne Domain mit ID " + DomainID + " aus dem Cache...");
      domains.remove(DomainID);
      domainLists.remove(DomainID);
    }
  }

  private void initDomain(long DomainID)
  {
    //if (logger.isDebugEnabled())
    //  logger.debug("initDomain() mit ID: " + DomainID);

    if (domains == null)
    {
      // Domain-Map erstellen
      if (logger.isDebugEnabled())
        logger.debug("initDomain(), neue Domain-Map erstellen");

      domains = new HashMap<Long, Map<String, DomainValue>>();
    }
    if (domainLists == null)
    {
      domainLists = new LinkedHashMap<Long, List<DomainValue>>();
    }
    if (defaultValues == null)
      defaultValues = new HashMap<Long, DomainValue>();

    if (domains.containsKey(DomainID) == false)
    {
      // Diese Domain laden
      //if (logger.isDebugEnabled())
      //  logger.debug("initDomain(), lade Domain mit ID " + DomainID);

      Session hb_session = HibernateUtil.getSessionFactory().openSession();
      //hb_session.getTransaction().begin();

      Domain domain = (Domain) hb_session.get(Domain.class, DomainID);

      if (domain != null)
      {
        String hql = "from DomainValue where domainId=" + DomainID;

        if (domain.getDisplayOrder() != null
                && domain.getDisplayOrder() == Definitions.DISPLAYORDER_ID)
        {
          hql += " order by domainValueId";
        }
        else if (domain.getDisplayOrder() != null
                && domain.getDisplayOrder() == Definitions.DISPLAYORDER_ORDERID)
        {
          hql += " order by orderNo";
        }
        else
          hql += " order by domainDisplay";

        List list = hb_session.createQuery(hql).list();

        domainLists.put(DomainID, list);

        //domain.getDefaultValue()
        // Eine Map mit allen DomainValues erstellen (DomainCode ist der Key)
        Map<String, DomainValue> map = new HashMap<String, DomainValue>();

        for (int i = 0; i < list.size(); ++i)
        {
          DomainValue dv = (DomainValue) list.get(i);
          map.put(dv.getDomainCode(), dv);
        }

        // Der Map mit allen Domains diese Map hinzufügen (DomainID ist der Key)
        domains.put(DomainID, map);

        // Transaktion abschließen
       
        hb_session.close();

        if (defaultValues.containsKey(DomainID) == false)
        {
          try
          {
            if (domain.getDefaultValue() != null)
              defaultValues.put(DomainID, getDomainValue(Integer.parseInt(domain.getDefaultValue())));
          }
          catch (Exception e)
          {
            logger.error("Fehler beim Lesen einer Default-Value mit ID '" + domain.getDefaultValue() + "': " + e.getMessage());
          }
        }
      }
      else
      {
        // Transaktion abschließen
        
        hb_session.close();
      }
    }


  }
  
  public String getComboboxCd(Combobox cb)
  {
    String cd = "";

    if (cb != null && cb.getSelectedItem() != null)
    {
      Object o = cb.getSelectedItem().getValue();
      if (o != null && o instanceof DomainValue)
      {
        DomainValue dv = (DomainValue) o;
        cd = dv.getDomainCode();
      }
    }

    return cd;
  }

  public String getRadiogroupCd(Radiogroup rg)
  {
    String cd = "";

    if (rg != null && rg.getSelectedItem() != null)
    {
      Object o = rg.getSelectedItem().getValue();
      if (o != null && o instanceof DomainValue)
      {
        DomainValue dv = (DomainValue) o;
        cd = dv.getDomainCode();
      }
    }

    return cd;
  }

  

  public void fillComponent(Component comp, long domainId, String selectedDomainValueCd)
  {
    fillComponent(comp, domainId, selectedDomainValueCd, false);
  }

  public void fillComponent(Component comp, long domainId, String selectedDomainValueCd, boolean disabled)
  {
    if (comp instanceof Combobox)
      fillCombobox((Combobox) comp, domainId, selectedDomainValueCd, disabled);
    else if (comp instanceof Radiogroup)
      fillRadiogroup((Radiogroup) comp, domainId, selectedDomainValueCd, disabled);
    else
      throw new NotYetImplementedException("Method not implemented for Class " + comp.getClass().getName());
  }

  public void fillCombobox(final Combobox cb, long DomainId, final String SelectedDomainValueCd)
  {
    fillCombobox(cb, DomainId, SelectedDomainValueCd, false);
  }

  public void fillCombobox(final Combobox cb, long DomainId, final String SelectedDomainValueCd, final boolean disabled)
  {
    logger.debug("fillCombobox mit DomainID: " + DomainId);

    List<DomainValue> list = DomainHelper.getInstance().getDomainList(DomainId);

    // Renderer erstellen
    cb.setItemRenderer(new ComboitemRenderer<DomainValue>()
    {
      public void render(Comboitem item, DomainValue dv, int i) throws Exception
      {
        if (dv != null)
        {
          item.setValue(dv);
          item.setLabel(dv.getDomainDisplay());

          if (disabled)
            item.setDisabled(true);

          if (SelectedDomainValueCd != null && dv.getDomainCode() != null && SelectedDomainValueCd.equals(dv.getDomainCode()))
          {
            cb.setSelectedItem(item);
            cb.setText(item.getLabel());
          }
        }
        else
          item.setLabel("");
      }
    });

    // Model erstellen und setzen
    cb.setModel(new ListModelList<DomainValue>(list));

  }

  public void fillRadiogroup(final Radiogroup rg, long DomainId, final String SelectedDomainValueCd)
  {
    fillRadiogroup(rg, DomainId, SelectedDomainValueCd, false);
  }

  public void fillRadiogroup(final Radiogroup rg, long DomainId, final String SelectedDomainValueCd, final boolean disabled)
  {
    logger.debug("fillRadiogroup mit DomainID: " + DomainId + ", disabled: " + disabled);

    List<DomainValue> list = DomainHelper.getInstance().getDomainList(DomainId);

    // Renderer erstellen
    rg.setRadioRenderer(new RadioRenderer<DomainValue>()
    {
      public void render(Radio item, DomainValue dv, int i) throws Exception
      {
        if (dv != null)
        {
          item.setValue(dv);
          item.setLabel(dv.getDomainDisplay());

          if (SelectedDomainValueCd != null && dv.getDomainCode() != null && SelectedDomainValueCd.equals(dv.getDomainCode()))
          {
//            logger.debug("Setze Auswahl: " + dv.getDomainCode());
            rg.setSelectedItem(item);
          }
        }
        else
        {
          item.setLabel("");
        }

        if (disabled)
          item.setDisabled(true);

        //item.setS
      }
    });

    rg.setModel(new ListModelList<DomainValue>(list));

  }
  
}

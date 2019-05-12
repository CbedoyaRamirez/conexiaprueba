package com.conexia.lamejorcocina.web;

import com.conexia.lamejorcocina.persistence.DetallefacturaFacadeLocal;
import com.conexia.lamejorcocina.persistence.FacturaFacadeLocal;
import com.conexia.lamejorcocina.vo.reporteTotalFacturadoVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Carlos
 */
@Named(value = "reporteMB")
@RequestScoped
public class ReporteMB {

    @EJB
    private DetallefacturaFacadeLocal detallefacturaFacade;

    @EJB
    private FacturaFacadeLocal facturaFacade;

    private List<reporteTotalFacturadoVO> listReporte;

    public ReporteMB() {
    }

    @PostConstruct
    public void init() {
        listReporte = new ArrayList<>();
    }

    public void reporteTotalFacturado() {
        List<Object> reporteResultado = new ArrayList<>();
        reporteResultado = facturaFacade.consultarSumaTotalFacturadoCamarero();
        llenarVoReporteTotalFacturado(reporteResultado);
    }

    public void reporteGastoSuperior() {
        List<Object> reporteResultado = new ArrayList<>();
        reporteResultado = facturaFacade.consultarSumaSuperiorCliente();
        llenarVoReporteSumaSuperiorFacturado(reporteResultado);
    }

    public void llenarVoReporteTotalFacturado(List<Object> obj) {
        Iterator itr = obj.iterator();
        while (itr.hasNext()) {
            Object[] objitr = (Object[]) itr.next();
            reporteTotalFacturadoVO reporteVo = new reporteTotalFacturadoVO();
            reporteVo.setNombre(objitr[10].toString());
            reporteVo.setApellido(objitr[12].toString() + " " + objitr[13].toString());
            if (Objects.nonNull(objitr[4])) {
                reporteVo.setMes(objitr[4].toString());
            }
            if (Objects.nonNull(objitr[14])) {
                reporteVo.setSuma(objitr[14].toString());
            }
            listReporte.add(reporteVo);
        }
    }

    public void llenarVoReporteSumaSuperiorFacturado(List<Object> obj) {
        Iterator itr = obj.iterator();
        while (itr.hasNext()) {
            Boolean noInsertar = false;
            Object[] objitr = (Object[]) itr.next();
            reporteTotalFacturadoVO reporteVo = new reporteTotalFacturadoVO();
            reporteVo.setNombre(objitr[0].toString());
            reporteVo.setApellido(objitr[1].toString() + " " + objitr[1].toString());
            if (Objects.nonNull(objitr[2])) {
                reporteVo.setMes(objitr[2].toString());
            }
            if (Objects.nonNull(objitr[3])) {
                reporteVo.setSuma(objitr[3].toString());
            } else {
                noInsertar = true;
            }
            if (!noInsertar) {
                listReporte.add(reporteVo);
            }
        }
    }

    public List<reporteTotalFacturadoVO> getListReporte() {
        return listReporte;
    }

    public void setListReporte(List<reporteTotalFacturadoVO> listReporte) {
        this.listReporte = listReporte;
    }

}
